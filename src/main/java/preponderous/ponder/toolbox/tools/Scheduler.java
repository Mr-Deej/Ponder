package preponderous.ponder.toolbox.tools;

import org.bukkit.Bukkit;
import preponderous.ponder.PonderAPI;
import preponderous.ponder.services.specification.IExpandedStorageService;
import preponderous.ponder.toolbox.tools.specification.IScheduler;

public class Scheduler implements IScheduler {

    private PonderAPI ponderAPI;

    public Scheduler(PonderAPI ponderAPI) {
        this.ponderAPI = ponderAPI;
    }

    /**
     * Method to schedule an hourly autosave. This requires an expanded storage service.
     *
     */
    @Override
    public void scheduleAutosave(IExpandedStorageService storageService) {
        int delay = 60 * 60; // 1 hour
        int secondsUntilRepeat = 60 * 60; // 1 hour
        Bukkit.getScheduler().scheduleSyncRepeatingTask(ponderAPI.getPlugin(), new Runnable() {
            @Override
            public void run() {
                storageService.save();
            }
        }, delay * 20, secondsUntilRepeat * 20);
    }

}
