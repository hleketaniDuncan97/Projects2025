@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountType(String accountType);
}