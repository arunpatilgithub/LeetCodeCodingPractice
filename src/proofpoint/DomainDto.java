package proofpoint;

import java.util.Objects;

public class DomainDto {

    private String fqdn;
    private String currentStatus;
    private String updateStatus;
    private String existingHash;
    private String updatedHash;

    public DomainDto(String fqdn, String currentStatus, String updateStatus, String existingHash, String updatedHash) {
        this.fqdn = fqdn;
        this.currentStatus = currentStatus;
        this.updateStatus = updateStatus;
        this.existingHash = existingHash;
        this.updatedHash = updatedHash;
    }

    public String getFqdn() {
        return fqdn;
    }

    public void setFqdn(String fqdn) {
        this.fqdn = fqdn;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(String updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getExistingHash() {
        return existingHash;
    }

    public void setExistingHash(String existingHash) {
        this.existingHash = existingHash;
    }

    public String getUpdatedHash() {
        return updatedHash;
    }

    public void setUpdatedHash(String updatedHash) {
        this.updatedHash = updatedHash;
    }


}
