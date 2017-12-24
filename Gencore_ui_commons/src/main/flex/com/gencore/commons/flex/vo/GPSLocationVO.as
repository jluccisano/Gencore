package com.gencore.commons.flex.vo
{
	[Bindable]
	[RemoteClass(alias="com.gencore.backend.java.entity.GPSLocation")]
	public class GPSLocationVO
	{
		public var id:Number;
		public var course:CourseVO;
		public var acquisitionDate:Date;
		public var lattitude:Number;
		public var longitude:Number;
		public var altitude:Number;		
	}
}