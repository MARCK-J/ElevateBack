package ucb.edu.bo.Elevate.DTO;

import java.util.List;
import ucb.edu.bo.Elevate.Entity.Courses;

public class CustomResponseDTO {
    private String code;
    private Result result;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomResponseDTO(String code, Result result, String message) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    // Getters y Setters

    public static class Result {
        private List<Courses> content;
        private long totalItems;
        private int totalPages;
        private int currentPage;

        public List<Courses> getContent() {
            return content;
        }

        public void setContent(List<Courses> content) {
            this.content = content;
        }

        public long getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(long totalItems) {
            this.totalItems = totalItems;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public Result(List<Courses> content, long totalItems, int totalPages, int currentPage) {
            this.content = content;
            this.totalItems = totalItems;
            this.totalPages = totalPages;
            this.currentPage = currentPage;
        }

        // Getters y Setters
    }
}
