/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brutelol.fights;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DeltaClock 
{
    private final List<DeltaClockEvent> clock = new LinkedList();
    
    public TimedFightEvent getNextEvent()
    {
        if (clock.isEmpty())
        {
            return null;
        }
        TimedFightEvent toReturn = clock.remove(0).aUse;
        return toReturn;
    }
    
    public void insertDeltaClock(TimedFightEvent aUse, double t)
    {
        if (t == 0)
        {
            throw new IllegalArgumentException("Passing a 0 to the delta clock is silly.");
        }
        if (clock.isEmpty())  //If the clock is empty.
        {
            clock.add(new DeltaClockEvent(aUse,t));
        }
        else
        {
            DeltaClockEvent event = new DeltaClockEvent(aUse,t);

            //Decrease the time by the first event.
            Iterator<DeltaClockEvent> i = clock.listIterator();
        
            DeltaClockEvent lookingAt = i.next();
            int x = 0;
            event.time -= lookingAt.time;

            //We know that if the time ends up negative, that the task should be *before* the 
            //task that made the time end up as negative.
            while (event.time > 0)
            {
                if (!i.hasNext())
                {
                    clock.add(event);
                    return;
                }
                //Iterate to the next task.
                lookingAt = i.next();
                x++;
                //Subtract that task's time from our task.
                event.time -= lookingAt.time;
            }
            //If we end up with a negative time, we break out of the loop and end up here.
            //Undo that subtraction. We now have the time *past* the last task.
            event.time += lookingAt.time;
            //Subtract that from the proceeded task's time.
            lookingAt.time -= event.time;
            //Reroute links to insert the task into the linked list.
            clock.add(x,event);
        }
    }

    public TimedFightEvent[] getOrder() 
    {
        TimedFightEvent[] toReturn = new TimedFightEvent[clock.size()];
        for (int x = 0; x < clock.size(); x++)
        {
            toReturn[x] = clock.get(x).aUse;
        }
        return toReturn;
    }
    
    public void deleteClockEvent(TimedFightEvent aUse)
    {
        int count = 0;
        for (int i = clock.size()-1; i > -1; i--)
        {
            if (clock.get(i).aUse==aUse)
            {
                double timeToAddBackOn = clock.get(i).time;
                clock.remove(i);
                count++;
                if (i<clock.size())
                {
                    clock.get(i).time+=timeToAddBackOn;
                }
            }
        }
        System.out.println("Deleted "+count+" instances of "+aUse+" from the delta clock.");
    }
    
    public double getTimeUntilNextEvent()
    {
        return clock.get(0).time;
    }
    
    public boolean hasAnotherEvent()
    {
        return !clock.isEmpty();
    }
    
    private class DeltaClockEvent
    {
        public TimedFightEvent aUse;
        public double time;
        public DeltaClockEvent(TimedFightEvent aUse, double t)
        {
            this.aUse = aUse;
            time = t;
        }
        
        @Override
        public boolean equals(Object o)
        {
            if (o instanceof DeltaClockEvent)
            {
                return (((DeltaClockEvent)o).aUse==aUse);
            }
            return false;
        }
    }
}