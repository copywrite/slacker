package com.copywrite.slacker.storage;

import com.copywrite.slacker.storage.domain.PluginConfig;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nullable;

@com.intellij.openapi.components.State(
        name = "PluginConfig",
        storages = {
                @Storage(
                        file = StoragePathMacros.APP_CONFIG + "/autoGenerator.xml"
                )}
)
public class PluginConfigHolder implements PersistentStateComponent<PluginConfig> {
    public PluginConfig pluginConfig = new PluginConfig();
    @Nullable
    @Override
    public PluginConfig getState() {
        return pluginConfig;
    }

    @Override
    public void loadState(PluginConfig state) {
        XmlSerializerUtil.copyBean(state, pluginConfig);
    }

    @Nullable
    public static PluginConfig getPluginConfig() {
        try {
            return ServiceManager.getService(PluginConfigHolder.class).getState();
        }catch (Exception e){
            return null;
        }
    }

}
