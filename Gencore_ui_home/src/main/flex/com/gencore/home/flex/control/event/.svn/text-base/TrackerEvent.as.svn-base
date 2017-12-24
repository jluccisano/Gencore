package com.gencore.home.flex.control.event
{
	import flash.utils.Dictionary;
	
	import org.lucciframework.luccimvc.controller.event.LucciEvent;
	
	
	public class TrackerEvent extends LucciEvent
	{
 
		public static const GET_TOTAL_DISTANCE_EVENT : String='get_total_distance_event';
		public static const GET_TOTAL_DISTANCE_ACK : String='get_total_distance_ack';
		
		public static const GET_RUNS_OF_TODAY_EVENT : String='get_runs_of_today_event';
		public static const GET_RUNS_OF_TODAY_ACK : String='get_runs_of_today_ack';
				
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