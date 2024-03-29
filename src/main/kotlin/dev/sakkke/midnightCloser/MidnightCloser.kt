package dev.sakkke.midnightCloser

import org.bukkit.plugin.java.JavaPlugin
import org.quartz.CronScheduleBuilder
import org.quartz.JobBuilder
import org.quartz.TriggerBuilder
import org.quartz.impl.StdSchedulerFactory

class MidnightCloser: JavaPlugin() {
    companion object {
        lateinit var instance: MidnightCloser
            private set
    }

    override fun onEnable() {
        logger.info("MidnightCloser enabled")

        instance = this

        val schedulerFactory = StdSchedulerFactory()
        val scheduler = schedulerFactory.scheduler
        scheduler.start()
        val midnightCloserJob = JobBuilder.newJob(MidnightCloserJob::class.java)
            .withIdentity("midnightCloserJob", "main")
            .build()
        val dailyTrigger = TriggerBuilder.newTrigger()
            .withIdentity("dailyTrigger", "main")
            .startNow()
            .withSchedule(CronScheduleBuilder.cronSchedule("0 0 4 * * ?"))
            .forJob("midnightCloserJob", "main")
            .build()
        scheduler.scheduleJob(midnightCloserJob, dailyTrigger)
    }
}