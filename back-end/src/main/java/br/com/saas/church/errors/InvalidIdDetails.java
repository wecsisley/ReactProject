package br.com.saas.church.errors;

public class InvalidIdDetails {

    private String title;
    private int status;
    private String detail;
    private long timestamp;
    private String developMessage;

    private InvalidIdDetails(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDevelopMessage() {
        return developMessage;
    }


    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developMessage(String developMessage) {
            this.developMessage = developMessage;
            return this;
        }

        public InvalidIdDetails build() {
            InvalidIdDetails invalidIdDetails = new InvalidIdDetails(title);
            invalidIdDetails.developMessage = this.developMessage;
            invalidIdDetails.timestamp = this.timestamp;
            invalidIdDetails.detail = this.detail;
            invalidIdDetails.status = this.status;
            return invalidIdDetails;
        }
    }
}
