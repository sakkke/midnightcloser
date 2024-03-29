package dev.sakkke.midnightCloser

import org.bukkit.Bukkit
import org.quartz.Job
import org.quartz.JobExecutionContext

class MidnightCloserJob: Job {
    override fun execute(p0: JobExecutionContext?) {
        Bukkit.getScheduler().runTask(MidnightCloser.instance, Runnable {
            MidnightCloser.instance.logger.info("Stopping server")
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "stop")
        })
    }
}