package com.gencore.commons.flex.vo
{
	[Bindable]
	[RemoteClass(alias="com.gencore.backend.java.entity.Device")]
	public class DeviceVO
	{
		
		public var id:Number;
		public var user:UserProfileVO;
		public var imei:String;

	}
}