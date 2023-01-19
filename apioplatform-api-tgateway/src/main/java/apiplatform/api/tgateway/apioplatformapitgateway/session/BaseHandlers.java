package apiplatform.api.tgateway.apioplatformapitgateway.session;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;

public interface BaseHandlers {

    void session(ChannelHandlerContext cx, final Channel channel, Object request);

    
}
