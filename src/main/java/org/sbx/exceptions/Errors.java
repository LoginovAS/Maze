package org.sbx.exceptions;

/**
 * Created by aloginov on 04.10.16.
 */
public enum Errors {

    DIRECTION_WALL_ERROR {
        public int getErrorCode(){
            return 10;
        }

        public String getErrorMessage(){
            return "The attempt to go into the wall.";
        }
    },

    DIRECTION_CLOSED_DOOR_ERROR {
        public int getErrorCode(){
            return 20;
        }

        public String getErrorMessage(){
            return "The attempt to go into the closed door.";
        }
    },

    DIRECTION_NEIGHBOURHOOD_ERROR {
        public int getErrorCode(){
            return 30;
        }

        public String getErrorMessage(){
            return "The rooms too far from each other.";
        }
    },

    SITE_CREATION_ERROR {
        public int getErrorCode() {
            return 40;
        }

        public String getErrorMessage() {
            return "Site cannot be created by strange reasons.";
        }
    },

    CLASS_STRUCTURE_ERROR {
        public int getErrorCode() {
            return 50;
        }

        public String getErrorMessage() {
            return "Class not found exception has been caught.";
        }
    };

    public abstract int getErrorCode();

    public abstract String getErrorMessage();
}
