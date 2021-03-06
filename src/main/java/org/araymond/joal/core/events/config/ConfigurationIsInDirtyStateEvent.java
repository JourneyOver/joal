package org.araymond.joal.core.events.config;

import com.google.common.base.Preconditions;
import org.araymond.joal.core.config.AppConfiguration;

/**
 * Created by raymo on 09/07/2017.
 */
public class ConfigurationIsInDirtyStateEvent {
    private final AppConfiguration configuration;

    public ConfigurationIsInDirtyStateEvent(final AppConfiguration configuration) {
        Preconditions.checkNotNull(configuration, "Configuration must not be null.");
        this.configuration = configuration;
    }

    public AppConfiguration getConfiguration() {
        return configuration;
    }
}
