package com.tanzuhao.core.util;

/**
 * twitter的snowflake算法 -- java实现
 * 
 */
public class Sequence {

	/**
	 * 获得一个数据库表id
	 * 
	 * @return Long
	 */
	public static Long getId() {
		long id = TwitterId.ID();
		String valueOf = String.valueOf(id);
		valueOf = valueOf.substring(2, valueOf.length());
		return Long.valueOf(Long.parseLong(valueOf));
	}

	public static String IdString() {
		long id = TwitterId.ID();
		return String.valueOf(id);
	}

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++)
		System.out.println(getId());
	}
	public static class TwitterId {

		public TwitterId(long workerId, long datacenterId) {
			sequence = 0L;
			lastTimestamp = -1L;
			if (workerId > 31L || workerId < 0L)
				throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0",
						new Object[] { Long.valueOf(31L) }));
			if (datacenterId > 31L || datacenterId < 0L) {
				throw new IllegalArgumentException(String.format(
						"datacenter Id can't be greater than %d or less than 0", new Object[] { Long.valueOf(31L) }));
			} else {
				this.workerId = workerId;
				this.datacenterId = datacenterId;
				return;
			}
		}

		public TwitterId() {
			sequence = 0L;
			lastTimestamp = -1L;
		}

		public synchronized long nextId() {
			long timestamp = timeGen();
			if (timestamp < lastTimestamp)
				throw new RuntimeException(
						String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
								new Object[] { Long.valueOf(lastTimestamp - timestamp) }));
			if (lastTimestamp == timestamp) {
				sequence = sequence + 1L & 4095L;
				if (sequence == 0L)
					timestamp = tilNextMillis(lastTimestamp);
			} else {
				sequence = 0L;
			}
			lastTimestamp = timestamp;
			return timestamp - 1420041600000L << 22 | datacenterId << 17 | workerId << 12 | sequence;
		}

		protected long tilNextMillis(long lastTimestamp) {
			long timestamp;
			for (timestamp = timeGen(); timestamp <= lastTimestamp; timestamp = timeGen())
				;
			return timestamp;
		}

		protected long timeGen() {
			return System.currentTimeMillis();
		}

		public static long ID() {
			return twitterId.nextId();
		}

		private static TwitterId twitterId = null;
		private long workerId;
		private long datacenterId;
		private long sequence;
		private long lastTimestamp;

		static {
			twitterId = new TwitterId();
		}
	}
}