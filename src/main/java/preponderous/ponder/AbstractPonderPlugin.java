package preponderous.ponder;

import org.bukkit.plugin.java.JavaPlugin;
import preponderous.ponder.misc.PonderAPI_Integrator;
import preponderous.ponder.toolbox.Toolbox;

/**
 * @author Daniel Stephenson
 */
public abstract class AbstractPonderPlugin extends JavaPlugin {

    protected PonderAPI_Integrator ponderAPI_integrator;
    protected Toolbox toolbox;
    protected String version = "v0.1-alpha-1";

    public boolean isDebugEnabled() {
        return getPonderAPI().getConfigService().getBoolean("debugMode");
    }

    public boolean isVersionMismatched() {
        String configVersion = getConfig().getString("version");
        if (configVersion == null) {
            return false;
        }
        return !configVersion.equalsIgnoreCase(getVersion());
    }

    public Ponder getPonderAPI() {
        return ponderAPI_integrator.getAPI();
    }

    public Toolbox getToolbox() {
        return toolbox;
    }

    public String getVersion() {
        return version;
    }

}
