package sukko.taxidermy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sukko.taxidermy.domain.request.PasswordCheckRequest;
import sukko.taxidermy.domain.request.TaxidermyDeleteRequest;
import sukko.taxidermy.domain.request.TaxidermyRegisterRequest;
import sukko.taxidermy.domain.request.TaxidermyUpdateRequest;
import sukko.taxidermy.domain.response.TaxidermyDetailResponse;
import sukko.taxidermy.domain.response.TaxidermySummaryResponse;
import sukko.taxidermy.service.TaxidermyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/taxidermy")
public class TaxidermyController {

    private final TaxidermyService taxidermyService;

    @GetMapping("/{id}")
    public TaxidermyDetailResponse getById(@PathVariable("id") Long id){
        return taxidermyService.getById(id);
    }

    @GetMapping
    public List<TaxidermySummaryResponse> getByCharacterName(@RequestParam("name") String name){
        return taxidermyService.getByCharacterName(name);
    }

    @GetMapping("/relation")
    public List<TaxidermySummaryResponse> getRelationByCharacterName(@RequestParam("name") String name){
        return taxidermyService.getRelationByCharacterName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody TaxidermyRegisterRequest request){
        taxidermyService.save(request);
    }

    @PostMapping("/{id}")
    public void passwordCheck(@PathVariable("id") Long id, @RequestBody PasswordCheckRequest request){
        taxidermyService.passwordCheck(id, request);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody TaxidermyUpdateRequest request){
        taxidermyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id, @RequestBody TaxidermyDeleteRequest request){
        taxidermyService.delete(id, request);
    }
}
