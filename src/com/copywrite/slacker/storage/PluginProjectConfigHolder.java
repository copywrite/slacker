package com.copywrite.slacker.storage;

import com.copywrite.slacker.storage.domain.PluginProjectConfig;
import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@com.intellij.openapi.components.State(
        name = "PluginProjectConfig",
        storages = {
                @Storage(id = "default", file = StoragePathMacros.PROJECT_FILE),
                @Storage(id = "dir", file = StoragePathMacros.PROJECT_CONFIG_DIR + "/autoProjectGenerator.xml", scheme = StorageScheme.DIRECTORY_BASED)
        }
)
public class PluginProjectConfigHolder implements PersistentStateComponent<PluginProjectConfig> {
    public PluginProjectConfig pluginProjectConfig = new PluginProjectConfig();

    @Nullable
    @Override
    public PluginProjectConfig getState() {
        return pluginProjectConfig;
    }

    @Override
    public void loadState(PluginProjectConfig state) {
        XmlSerializerUtil.copyBean(state, pluginProjectConfig);
    }

    @Nullable
    public static PluginProjectConfig getPluginProjectConfig() {
        if(Env.project==null)return null;
        try {
            return ServiceManager.getService(Env.project, PluginProjectConfigHolder.class).getState();
        }catch (Exception e){
            return null;
        }
    }

}
