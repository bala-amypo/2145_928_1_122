@Entity
public class SaleTransaction {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private DiscountCode discountCode;

    private BigDecimal saleAmount;

    private Timestamp transactionDate;

    @PrePersist
    void onCreate() {
        transactionDate = new Timestamp(System.currentTimeMillis());
    }
}
