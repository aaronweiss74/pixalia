package us.aaronweiss.pixalia.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundMessageHandlerAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import us.aaronweiss.pixalia.tools.Utils;

public class BufferLengthEncoder extends ChannelOutboundMessageHandlerAdapter<ByteBuf> {
	  private static final Logger logger = LoggerFactory.getLogger(BufferLengthEncoder.class);
	  
	  @Override
	  protected void flush(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		logger.info(Utils.toHexString(msg.array()));
		ctx.nextOutboundByteBuffer().writeByte(msg.readableBytes()).writeBytes(msg);
	}
}
