package com.navisow;

import com.navisow.processes.Process;
import com.navisow.processes.Sort02;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Sort02");
        Process process = new Sort02();
        process.go();
    }
}
