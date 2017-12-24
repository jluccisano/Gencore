package com.gencore.home.flex.view.mediator
{


    
    import com.gencore.home.flex.control.event.TrackerEvent;
    import com.gencore.home.flex.view.ContentUI;
    
    import mx.collections.ArrayCollection;
    
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;
    import org.lucciframework.luccimvc.view.mediator.Mediator;



	public class TrackerMediator extends Mediator
	{


		private function onResult(trackerEvent:TrackerEvent):void
		{

			switch (trackerEvent.type)
			{
				case (TrackerEvent.GET_RUNS_OF_TODAY_ACK):

					LucciEventDispatcher.instance.removeEventListener(TrackerEvent.GET_RUNS_OF_TODAY_ACK, onResult);

		
					if ( ArrayCollection(trackerEvent.data).length > 0 ) {
						//(this.getViewComponent("contentUI") as ContentUI).coursesOfToday = new ArrayCollection();
						(this.getViewComponent("contentUI") as ContentUI).coursesOfToday = trackerEvent.data;
						(this.getViewComponent("contentUI") as ContentUI).onMapReady();
					}
					
					break;

			}
		}


		public function getRunsOfToday():void
		{

			LucciEventDispatcher.instance.addEventListener(TrackerEvent.GET_RUNS_OF_TODAY_ACK, onResult);

			LucciEventDispatcher.instance.dispatchEvent(new TrackerEvent(TrackerEvent.GET_RUNS_OF_TODAY_EVENT));
		}


	}
}