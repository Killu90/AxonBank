package read.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import read.AccountQueryObject.AccountQueryObject;

@Repository
public interface AccountQueryObjectRepository extends JpaRepository<AccountQueryObject, String> {

}
