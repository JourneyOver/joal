package org.araymond.joal.core.events.announce;

import com.turn.ttorrent.common.protocol.TrackerMessage;
import org.araymond.joal.core.ttorent.client.announce.Announcer;
import org.araymond.joal.core.ttorent.client.bandwidth.TorrentWithStats;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by raymo on 09/07/2017.
 */
public class AnnouncerHasStartedEventTest {

    @Test
    public void shouldBuild() {
        final Announcer announcer = Mockito.mock(Announcer.class);
        final TorrentWithStats torrent = Mockito.mock(TorrentWithStats.class);
        Mockito.when(announcer.getSeedingTorrent()).thenReturn(torrent);
        final AnnouncerHasStartedEvent event = new AnnouncerHasStartedEvent(announcer);

        assertThat(event.getTorrent()).isEqualTo(torrent);
    }

}