public interface SaleTransactionRepository extends JpaRepository<SaleTransaction, Long> {
    List<SaleTransaction> findByDiscountCode_Id(Long codeId);
    List<SaleTransaction> findByDiscountCode_Influencer_Id(Long influencerId);
    List<SaleTransaction> findByDiscountCode_Campaign_Id(Long campaignId);
}
