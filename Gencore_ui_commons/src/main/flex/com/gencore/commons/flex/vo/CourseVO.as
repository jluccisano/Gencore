package com.gencore.commons.flex.vo
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="com.gencore.backend.java.entity.Course")]
	public class CourseVO
	{	
		public var id:Number;
		public var courseId:String;
		public var courseType:String;
		public var user:UserProfileVO;
		public var startDate:Date;
		public var endDate:Date;
		public var distance:Number;
		public var speedAverage:Number;
		public var kmAverage:Number;
		public var duration:Number;
		public var status:int;
		public var startLocation:GPSLocationVO;
		public var gpsLocations:ArrayCollection;
	}
}