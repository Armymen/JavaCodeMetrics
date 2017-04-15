package pl.pecet.javacodemetrics.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CodeMetrics {

	private final String className;

	private final String methodName;

	private final Integer linesOfCode;

	private final Integer nonCommentedLOC;

	private final Integer cyclomaticComplexity;

	private final Integer numberOfMethods;

	private final Integer numberOfBusinessMethods;

	private final Integer depthOfInheritanceTree;

	private final Integer numberOfChildren;
}
