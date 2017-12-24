package com.gencore.tracker.flex.control.event
{
	import flash.utils.Dictionary;
	
	import org.lucciframework.luccimvc.controller.event.LucciEvent;
	
	
	public class TrackerEvent extends LucciEvent
	{
		
		public static const GET_COURSE_EVENT : String='get_course_event';
		public static const GET_COURSE_ACK : String ='get_course_ack';
		
		public static const GET_COURSES_EVENT : String='get_courses_event';
		public static const GET_COURSES_ACK : String ='get_courses_ack';
				
		public var id : String;
		
		
		public function TrackerEvent( type : String , data : * = null,  id:String = null, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type,data,id,bubbles,cancelable);
			this.id = id;
			this.data = data;
		}
		
		private var _data : Dictionary;
		
	}
}