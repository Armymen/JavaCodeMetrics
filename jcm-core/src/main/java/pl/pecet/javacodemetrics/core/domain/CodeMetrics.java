package pl.pecet.javacodemetrics.core.domain;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodeMetrics {

	@Id
	private String id;

	private final String className;

	private final String methodName;

	private final Integer linesOfCode;

	private final Integer nonCommentedLOC;

	private final Integer cyclomaticComplexity;

	private final Integer numberOfMethod;

	private final Integer numberOfBusinessMethod;

	private final Integer depthOfInheritanceTree;

	private final Integer numberOfChildren;
}
