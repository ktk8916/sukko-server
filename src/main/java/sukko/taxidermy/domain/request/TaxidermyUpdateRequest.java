package sukko.taxidermy.domain.request;

public record TaxidermyUpdateRequest(
        String dungeon,
        String title,
        String content,
        String password
) {
}
