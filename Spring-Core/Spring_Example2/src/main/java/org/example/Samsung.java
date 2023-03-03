package org.example;

import org.springframework.beans.factory.annotation.Autowired;

public class Samsung {
    @Autowired
    MobileCPU cpu;
    public void config(){
        System.out.println("CPU: Octa-Core | RAM: 8 GB");
        cpu.CPU();
    }
}
