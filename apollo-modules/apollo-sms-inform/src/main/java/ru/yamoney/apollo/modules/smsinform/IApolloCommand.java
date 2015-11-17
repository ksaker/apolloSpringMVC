package ru.yamoney.apollo.modules.smsinform;

/**
 * ApolloCommand
 * <p>
 *     Common command
 * </p>
 *
 * @author Platonov Alexey
 * @version 1.0 11.11.15
 */
public interface IApolloCommand<RQ, RS> {

    /**
     * Common execution of apollo method
     *
     * @param request   request params
     * @return command response
     */
    RS execute(RQ request);
}
