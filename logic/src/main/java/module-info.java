module drawer.logic {
    requires drawer.util;

    requires guava;
    requires bson4jackson;
    requires org.mongodb.bson;
    requires jbcrypt;
    requires com.fasterxml.jackson.databind;

    exports by.bsuir.drawer.logic;
}
