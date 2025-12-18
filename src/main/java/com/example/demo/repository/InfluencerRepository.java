public interface InfluencerRepository extends JpaRepository<Influencer, Long> {
    Influencer findBySocialHandle(String handle);
}
