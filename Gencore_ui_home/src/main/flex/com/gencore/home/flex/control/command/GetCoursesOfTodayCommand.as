package com.gencore.home.flex.control.command {

  
    

    import com.gencore.commons.flex.manager.ErrorManager;
    import com.gencore.home.flex.business.TrackerDelegate;
    import com.gencore.home.flex.control.event.TrackerEvent;
    
    import mx.controls.Alert;
    import mx.rpc.IResponder;
    import mx.rpc.events.FaultEvent;
    import mx.rpc.events.ResultEvent;
    
    import org.lucciframework.luccimvc.controller.command.Command;
    import org.lucciframework.luccimvc.controller.event.LucciEvent;
    import org.lucciframework.luccimvc.controller.event.LucciEventDispatcher;



    public class GetCoursesOfTodayCommand extends Command implements IResponder {
        private var trackerEvent : TrackerEvent;
		
		//private var LOG:Logger = LogContext.getLogger(GetCoursesOfTodayCommand);


        override protected function execute(event : LucciEvent) : void {

            trackerEvent = TrackerEvent(event);

            super.execute(trackerEvent);

            var delegate : TrackerDelegate = new TrackerDelegate(this);

            delegate.getCoursesOfToday();
			
			//LOG.info("get courses of today");

        }

        override public function result(data : Object) : void {

            var event : ResultEvent = data as ResultEvent;

            LucciEventDispatcher.instance.dispatchEvent(new TrackerEvent(TrackerEvent.GET_RUNS_OF_TODAY_ACK, event.result));
        }

        override public function fault(data : Object) : void {

            var faultEvt : FaultEvent = data as FaultEvent;

            Alert.show(ErrorManager.displayMessage(faultEvt.fault.faultCode));


        }
    }
}