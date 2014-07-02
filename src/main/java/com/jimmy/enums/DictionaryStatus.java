package com.jimmy.enums;

import java.util.ArrayList;
import java.util.List;

public enum DictionaryStatus {
    New {
        @Override
        public String getName() {
            return "new";
        }
    },
    Know {
        @Override
        public String getName() {
            return "know";
        }
    },
    Faliliar {
        @Override
        public String getName() {
            return "familiar";
        }
    },
    Master {
        @Override
        public String getName() {
            return "master";
        }
    };

    public abstract String getName();

    private static final List<DictionaryStatus> allStatus = getAllEnum();

    public static final List<DictionaryStatus> getAllEnum() {
        List<DictionaryStatus> list = new ArrayList<DictionaryStatus>();
        list.add(New);
        list.add(Know);
        list.add(Faliliar);
        list.add(Master);
        return list;
    }

    public static DictionaryStatus getEnumFromName(String status) {
        for (DictionaryStatus e : allStatus) {
            if (status.equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    public static int getIndexFromName(String status) {
        for (int i = 0; i < allStatus.size(); i++) {
            if (status.equals(allStatus.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

}
