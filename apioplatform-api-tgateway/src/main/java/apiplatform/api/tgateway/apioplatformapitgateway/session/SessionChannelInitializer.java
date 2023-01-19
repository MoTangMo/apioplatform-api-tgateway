package apiplatform.api.tgateway.apioplatformapitgateway.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

public class SessionChannelInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline line = channel.pipeline();
        
    }
}
