@Entity
public class RoiReport {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Campaign campaign;

    @ManyToOne
    private Influencer influencer;

    private BigDecimal totalSales;
    private BigDecimal totalRevenue;
    private BigDecimal roiPercentage;

    private Timestamp generatedAt;

    @PrePersist
    void onCreate() {
        generatedAt = new Timestamp(System.currentTimeMillis());
    }
}
