package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import objects.Basicobject;
import objects.Myobject;

public class Createline extends Mymode {
    Point start, end ;

    protected Point getport( Myobject obj, String direction ) {
        Point temp = null ;
        if ( direction == "up" )
            temp = obj.getport(0);
        else if ( direction == "down" )
            temp = obj.getport(1);
        else if ( direction == "left" )
            temp = obj.getport(2);
        else if ( direction == "right" )
            temp = obj.getport(3);
        

        return temp ;
    }

    
}
