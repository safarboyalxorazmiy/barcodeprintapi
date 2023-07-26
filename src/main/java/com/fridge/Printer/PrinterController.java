package com.fridge.Printer;

import com.fridge.Printer.dto.PrintRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/printer")
public class PrinterController {
    private final PrinterService printerService;

    @PostMapping("/print")
    public String print(@RequestBody PrintRequestDTO dto) {
        return printerService.print(dto);
    }
}