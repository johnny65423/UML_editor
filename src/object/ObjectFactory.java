package object;

import java.awt.Point;

public class ObjectFactory {
    public static Myobject createObject( String type, Point p1, Point p2 ) {
        if ( type == "Class" )
            return new ClassObject(p1.x, p1.y) ;
        else if ( type == "UseCase" )
            return new UseCaseObject(p1.x, p1.y) ;
        else if ( type == "Association" )
            return new AssociationLine(p1, p2) ;
        else if ( type == "Composition" )
            return new CompositionLine(p1, p2) ;
        else if ( type == "Generalization" )
            return new GeneralizationLine(p1, p2) ;
        else if ( type == "Composite" )
            return new Composite() ;
        else if ( type == "Area" )
            return new Area(p1, p2) ;

        return null ;

    }
}
