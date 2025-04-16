package id.co.bsi.hello_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final List<Map<String, Object>> transactions = new ArrayList<>();

    public TransactionController() {
        transactions.add(createTransaction("Transfer", "Sendy", "Fore Coffee", -75000));
        transactions.add(createTransaction("Topup", null, "Topup from Bank Transfer", 1000000));
        transactions.add(createTransaction("Transfer", "Spongebob", "Fore Coffee", -75000));
        transactions.add(createTransaction("Topup", null, "Topup from Bank Transfer", 1000000));
        transactions.add(createTransaction("Transfer", "Anwar", "Beli barang", -75000));
        transactions.add(createTransaction("Transfer", "Joko", "Transfer", 1000000));
        transactions.add(createTransaction("Transfer", "Joko", "Fore Coffee", -75000));
        transactions.add(createTransaction("Topup", null, "Topup from Bank Transfer", 1000000));
        transactions.add(createTransaction("Transfer", "Joko", "Fore Coffee", -75000));
        transactions.add(createTransaction("Topup", null, "Topup from Bank Transfer", 1000000));
    }

    private Map<String, Object> createTransaction(String type, String fromTo, String description, long amount) {
        Map<String, Object> tx = new HashMap<>();
        tx.put("datetime", LocalDateTime.of(2022, 6, 30, 20, 10));
        tx.put("type", type);
        tx.put("from_to", fromTo);
        tx.put("description", description);
        tx.put("amount", amount);
        return tx;
    }

    @GetMapping
    public ResponseEntity<?> getTransactions(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int limit,
            @RequestParam(required = false) String sort_by,
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String search
    ) {
        try {
            List<Map<String, Object>> result = new ArrayList<>(transactions);
            //searching
            if (search != null && !search.isEmpty()) {
                result = result.stream()
                        .filter(t -> ((String) t.get("description")).toLowerCase().contains(search.toLowerCase()))
                        .collect(Collectors.toList());

                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "total_data", result.size(),
                        "page", page,
                        "limit", limit,
                        "transactions", result
                ));
            }

            // sorting
            if ("amount".equalsIgnoreCase(sort_by)) {
                if (!"asc".equalsIgnoreCase(order) && !"desc".equalsIgnoreCase(order)) {
                    return ResponseEntity.badRequest().body(Map.of(
                            "status", "failed",
                            "message", "invalid query parameter"
                    ));
                }
                result.sort((a, b) -> {
                    Long amountA = (Long) a.get("amount");
                    Long amountB = (Long) b.get("amount");
                    return "desc".equalsIgnoreCase(order)
                            ? Long.compare(amountB, amountA)
                            : Long.compare(amountA, amountB);
                });

                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "transactions", result
                ));
            }

            // pagination
            int fromIndex = (page - 1) * limit;
            int toIndex = Math.min(fromIndex + limit, result.size());
            if (fromIndex >= result.size()) {
                return ResponseEntity.ok(Map.of(
                        "status", "success",
                        "transactions", List.of()
                ));
            }

            List<Map<String, Object>> pagedResult = result.subList(fromIndex, toIndex);

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "transactions", pagedResult
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "status", "failed",
                    "message", "unable fetch list all transactions"
            ));
        }
    }
}