package org.example.task_4;

import java.util.ArrayList;

public class Result {
    public final boolean success;
    public final ArrayList<Double> values;
    public final String errorMessage;
    public final int errorCode; // 0 - успех, 1 - файл, 2 - формат

    public Result(ArrayList<Double> values) {
        this.success = true;
        this.values = values;
        this.errorMessage = null;
        this.errorCode = 0;
    }

    public Result(int errorCode, String errorMessage) {
        this.success = false;
        this.values = null;
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
