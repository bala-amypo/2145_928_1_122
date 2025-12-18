public interface RoiReportRepository extends JpaRepository<RoiReport, Long> {
    List<RoiReport> findByCampaign_Id(Long campaignId);
}
