package com.cursovaya.interfaces;

public enum whois {
    guest(2){
        public String action() {
        return "Гость";
        }
        },
    participant(1){
        public String action() {
            return "Участник";
        }
        },
    jury (0){
        public String action() {
            return "Жюри";
        }
    };

    int relationBtwNumb;

    whois(int i){
        relationBtwNumb = i;
    }


    public int getRelationBtwNumber() {
        return relationBtwNumb;
    }



    public abstract String action();

}
