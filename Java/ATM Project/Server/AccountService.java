@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public float getBalance(String accountType) {
        Optional<Account> optionalAccount = accountRepository.findByAccountType(accountType);
        return optionalAccount.map(Account::getBalance).orElse(0.0f);
    }

    public void deposit(String accountType, float amount) {
        Optional<Account> optionalAccount = accountRepository.findByAccountType(accountType);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            float currentBalance = account.getBalance();
            account.setBalance(currentBalance + amount);
            accountRepository.save(account);
        }
    }

    public boolean withdraw(String accountType, float amount) {
        Optional<Account> optionalAccount = accountRepository.findByAccountType(accountType);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            float currentBalance = account.getBalance();
            if (amount <= currentBalance) {
                account.setBalance(currentBalance - amount);
                accountRepository.save(account);
                return true;
            }
        }
        return false;
    }

    public boolean transfer(String fromAccountType, String toAccountType, float amount) {
        Optional<Account> optionalFromAccount = accountRepository.findByAccountType(fromAccountType);
        Optional<Account> optionalToAccount = accountRepository.findByAccountType(toAccountType);

        if (optionalFromAccount.isPresent() && optionalToAccount.isPresent()) {
            Account fromAccount = optionalFromAccount.get();
            Account toAccount = optionalToAccount.get();
            float fromBalance = fromAccount.getBalance();

            if (amount <= fromBalance) {
                fromAccount.setBalance(fromBalance - amount);
                toAccount.setBalance(toAccount.getBalance() + amount);
                accountRepository.save(fromAccount);
                accountRepository.save(toAccount);
                return true;
            }
        }
        return false;
    }
}
