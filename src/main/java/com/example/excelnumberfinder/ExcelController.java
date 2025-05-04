package com.example.excelnumberfinder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Excel Numbers", description = "Find Nth smallest number in Excel")
public class ExcelController {

    @PostMapping("/find-min")
    @Operation(summary = "Find Nth smallest number")
    public int findNthMin(@RequestParam String filePath, @RequestParam int n) {
        List<Integer> numbers = ExcelReader.readNumbers(filePath);
        return QuickSelect.findNthMin(numbers, n);
    }
}
