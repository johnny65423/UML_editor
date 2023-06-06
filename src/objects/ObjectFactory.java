package objects;

import java.awt.Point;

public class ObjectFactory {
    public static Myobject createObject( String type, Point p1, Point p2 ) {
        if ( type == "Class" )
            return new Classobject(p1.x, p1.y) ;
        else if ( type == "UseCase" )
            return new Usecaseobject(p1.x, p1.y) ;
        else if ( type == "Association" )
            return new Associationline(p1, p2) ;
        else if ( type == "Composition" )
            return new Compositionline(p1, p2) ;
        else if ( type == "Generalization" )
            return new Generalizationline(p1, p2) ;
        else if ( type == "Composite" )
            return new Composite() ;
        else if ( type == "Area" )
            return new Area(p1, p2) ;

        return null ;

    }
}
