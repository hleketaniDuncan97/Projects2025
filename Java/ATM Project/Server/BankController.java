@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{accountType}/balance")
    public ResponseEntity<Float> getBalance(@PathVariable("accountType") String accountType) {
        float balance = accountService.getBalance(accountType);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/{accountType}/deposit")
    public ResponseEntity<String> deposit(@PathVariable("accountType") String accountType, @RequestBody float amount) {
        accountService.deposit(accountType, amount);
        return ResponseEntity.ok("Deposited successfully.");
    }

    @PostMapping("/{accountType}/withdraw")
    public ResponseEntity<String> withdraw(@PathVariable("accountType") String accountType, @RequestBody float amount) {
        if (accountService.withdraw(accountType, amount)) {
            return ResponseEntity.ok("Withdrawn successfully.");
        } else {
            return ResponseEntity.badRequest().body("Insufficient balance.");
        }
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam String fromAccountType, @RequestParam String toAccountType,
            @RequestParam float amount) {
        if (accountService.transfer(fromAccountType, toAccountType, amount)) {
            return ResponseEntity.ok("Transferred successfully.");
        } else {
            return ResponseEntity.badRequest().body("Transfer failed. Check account balances.");
        }
    }
}
