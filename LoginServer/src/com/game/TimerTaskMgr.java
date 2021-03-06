package com.game;

import java.util.Timer;
import java.util.TimerTask;

import com.util.Log;

public class TimerTaskMgr
{
	private static Timer scanTimer;
	private static TimerTask checkDBPool;

	public static Timer getScanTimer()
	{
		return scanTimer;
	}

	public static void init()
	{
		scanTimer = new Timer("ScanTimer");
		checkDBPool = new DBPool();
		scanTimer.schedule(checkDBPool, 60000 * 3, 60000 * 5);
	}
}

class DBPool extends TimerTask
{
	@Override
	public void run()
	{
		try
		{
//			DBPoolMgr.getInstance().checkConnectionPool();
		}
		catch (Exception e)
		{
			Log.error("检查数据库连接的定时任务异常", e);
		}
	}
}
