package com.ers.runes.utilities;

/**
 * Created by Benjamin on 2014-12-12.
 */
public class Util {
    public enum BlockSide {
        Bottom(0),
        Top(1),
        North(2),
        South(3),
        West(4),
        East(5);

        public int value = 0;

        private BlockSide(int value) {
            this.value = value;
        }
    }
}
